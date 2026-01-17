package com.dev.spring_boot_rest_api_basics.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RestController
public class FilteringController {

    @GetMapping("/filtering") //field2
    public MappingJacksonValue filtering() {

        SomeBean bean = new SomeBean("value1", "value2", "value3");

        return getMappingJacksonValue(new MappingJacksonValue(bean), Set.of("field1"));
    }

    @GetMapping("/filtering-list") //field2, field3
    public MappingJacksonValue filteringList() {
        List<SomeBean> beanList = Arrays.asList(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"),
                new SomeBean("value7", "value8", "value9")
        );

        return getMappingJacksonValue(new MappingJacksonValue(beanList), Set.of("field3"));
    }

    private static MappingJacksonValue getMappingJacksonValue(MappingJacksonValue someBean, Set<String> fields) {

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        someBean.setFilters(filters);
        return someBean;
    }

}
