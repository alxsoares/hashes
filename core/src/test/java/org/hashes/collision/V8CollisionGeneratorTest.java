/*******************************************************************************
 *
 *    Copyright 2012 Pedro Ribeiro
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *    
 *******************************************************************************/
package org.hashes.collision;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * V8CollisionGenerator tests.
 * 
 * @author ribeirux
 * @version $Revision$
 */
@Test(groups = "functional", testName = "collision.V8CollisionGeneratorTest")
public class V8CollisionGeneratorTest {

    public void testCollisions() {
        final String seed = "hashes";
        final int numberOfKeys = 1000;

        final V8CollisionGenerator gen = new V8CollisionGenerator(seed);
        final List<String> collisions = gen.generateCollisions(numberOfKeys);

        Assert.assertEquals(collisions.size(), numberOfKeys);

        final int seedHash = gen.hashForth(seed);

        for (final String key : collisions) {
            Assert.assertEquals(seedHash, gen.hashForth(key));
        }
    }
}