/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreemnets.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0 
 * (the "License"); you may not use this file except in compliance with 
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package opennlp.tools.util;

import java.util.Arrays;

import junit.framework.TestCase;

/**
 * Tests for the {@link Sequence} class.
 */
public class SequenceTest extends TestCase {

  /**
   * Tests the copy constructor {@link Sequence#Sequence(Sequence)}.
   */
  public void testCopyConstructor() {
    Sequence sequence = new Sequence();
    sequence.add("a", 10);
    sequence.add("b", 20);
    
    Sequence copy = new Sequence(sequence);

    assertEquals(sequence.getOutcomes(), copy.getOutcomes());
    assertTrue(Arrays.equals(sequence.getProbs(), copy.getProbs()));
    assertTrue(sequence.compareTo(copy) == 0);
  }
  
  /**
   * Tests {@link Sequence#add(String, double)}, also
   * tests {@link Sequence#getOutcomes()} and {@link Sequence#getProbs()}.
   */
  public void testAddMethod() {
    Sequence sequence = new Sequence();
    sequence.add("a", 10);
    
    // check if insert was successful
    assertEquals("a", sequence.getOutcomes().get(0));
    assertEquals(10d, sequence.getProbs()[0]);
  }
  
  /**
   * Tests {@link Sequence#compareTo(Sequence)}.
   */
  public void testCompareTo() {
    Sequence lowScore = new Sequence();
    lowScore.add("A", 1d);
    lowScore.add("B", 2d);
    lowScore.add("C", 3d);
    
    Sequence highScore = new Sequence();
    lowScore.add("A", 7d);
    lowScore.add("B", 8d);
    lowScore.add("C", 9d);
    
    assertEquals(-1, lowScore.compareTo(highScore));
    assertEquals(1, highScore.compareTo(lowScore));
    assertEquals(0, highScore.compareTo(highScore));
  }
  
  /**
   * Checks that {@link Sequence#toString()} is executable.
   */
  public void testToString() {
    new Sequence().toString();
    
    Sequence sequence = new Sequence();
    sequence.add("test", 0.1d);
    sequence.toString();
  }
}