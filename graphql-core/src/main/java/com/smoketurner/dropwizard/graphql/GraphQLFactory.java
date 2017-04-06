/**
 * Copyright 2017 Smoke Turner, LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smoketurner.dropwizard.graphql;

import java.util.concurrent.atomic.AtomicReference;
import graphql.servlet.GraphQLServlet;
import graphql.servlet.OsgiGraphQLServlet;

public class GraphQLFactory {

    private final AtomicReference<GraphQLServlet> instance = new AtomicReference<>();

    public GraphQLServlet build() {
        final GraphQLServlet servlet = new OsgiGraphQLServlet();
        if (instance.compareAndSet(null, servlet)) {
            return servlet;
        }
        return instance.get();
    }
}