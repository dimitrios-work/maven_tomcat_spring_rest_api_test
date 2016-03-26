/*
 * Copyright (C) 2016 Dimitrios Dimas <dimitrios.work@outlook.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package lab.home.maven_tomcat_spring_rest_api_test;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dimitrios Dimas <dimitrios.work@outlook.com>
 */
@RestController
public class Controller {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/personalizedhello/{name}")
    public String personalizedHello(@PathVariable String name) {

        String msg = "Why, hello " + name;
        return msg;
    }

    @RequestMapping("/statefuljsonhello")
    public JSONHello jsonHello(@RequestParam(value = "name", defaultValue = "Multiverse!") String name) {
        return new JSONHello(counter.incrementAndGet(),
                "Hello " + name + ", SPRING automatically picked MappingJackson2HttpMessageConverter for you and returned a json object!, Don't you love spring?!");
    }
}
