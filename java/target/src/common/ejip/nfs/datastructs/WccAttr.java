/*
 * Copyright (c) Daniel Reichhard, daniel.reichhard@gmail.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *	This product includes software developed by Daniel Reichhard
 *
 * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 */
package ejip.nfs.datastructs;

import ejip.nfs.Xdr;

public class WccAttr {
	/**
	 * file size in bytes
	 */
	public long	size;
	/**
	 * last modification time
	 */
	public Nfstime3   mtime = new Nfstime3();
	/**
	 * last attribute change time
	 */
	public Nfstime3	 ctime = new Nfstime3();
	
	public void getWccAttr(StringBuffer sb) {
		size = Xdr.getNextLong(sb);
		mtime.loadFields(sb);
		ctime.loadFields(sb);
	}
	
	public void appendToStringBuffer(StringBuffer sb) {
		Xdr.append(sb, size);
		Xdr.append(sb, mtime.getSeconds());
		Xdr.append(sb, mtime.getNseconds());
		Xdr.append(sb, ctime.getSeconds());
		Xdr.append(sb, ctime.getNseconds());
	}
	
	public String toString() {
		return "Size:\t" + size + 
			"\nmtime:\n" + 
			mtime.toString() + 
			"\nctime:\n" +
			ctime.toString(); 
	}
}
