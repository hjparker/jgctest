/*
 * This file is part of JOP, the Java Optimized Processor
 *   see <http://www.jopdesign.com/>
 *
 * Copyright (C) 2011, Stefan Hepp (stefan@stefant.org).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jopdesign.jcopter.greedy;

import com.jopdesign.common.MethodInfo;
import com.jopdesign.jcopter.analysis.StacksizeAnalysis;
import org.apache.bcel.generic.InstructionHandle;

import java.util.Collection;
import java.util.Set;

/**
 * Interface for a candidate selector implementation. The selector gets sets of optimization candidates
 * and needs to return a subset of candidates to optimize next.
 *
 * <p>The selector is also responsible for checking codesize constraints, both global and per method.</p>
 *
 * @author Stefan Hepp (stefan@stefant.org)
 */
public interface CandidateSelector {

    void initialize();

    void addCandidates(MethodInfo method, Collection<Candidate> candidates);

    void removeCandidates(MethodInfo method);

    void removeCandidates(MethodInfo method, InstructionHandle start, InstructionHandle end);

    void updateSelection();

    void updateSelection(Set<MethodInfo> changedMethods);

    Collection<Candidate> selectNextCandidates();

    Collection<Candidate> getCandidates(MethodInfo method);

    void updateCandidates(MethodInfo method, StacksizeAnalysis stacksizeAnalysis);

}