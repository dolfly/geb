/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package modules

import geb.module.UrlInput
import geb.test.GebSpecWithCallbackServer

class UrlInputSnippetSpec extends GebSpecWithCallbackServer {

    def "using url input module"() {
        given:
        html """
            // tag::html[]
            <html>
                <body>
                    <input type="url" name="homepage"/>
                </body>
            </html>
            // end::html[]
        """

        when:
        // tag::example[]
        def input = $(name: "homepage").module(UrlInput)
        input.text = "https://groovy.apache.org/geb/"

        // end::example[]
        then:
        // tag::example[]
        assert input.text == "https://groovy.apache.org/geb/"
        // end::example[]
    }

}
