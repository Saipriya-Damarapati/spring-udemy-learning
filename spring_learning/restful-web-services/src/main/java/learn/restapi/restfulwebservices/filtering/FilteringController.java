package learn.restapi.restfulwebservices.filtering;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("filtering")
	public SomeBean filtering() {
		return new SomeBean("value1", "value2", "value3");
	}
	
	@GetMapping("filtering-list")
	public List<SomeBean> filteringList() {
		return List.of(new SomeBean("value01", "value02", "value03"),
						new SomeBean("value11", "value12", "value13"),
						new SomeBean("value21", "value22", "value23"));
	}
	
	@GetMapping("dynamic-filtering")
	public MappingJacksonValue dynamicFiltering() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}
	
	@GetMapping("dynamic-filtering-list")
	public MappingJacksonValue dynamicFilteringList() {
		List<SomeBean> someBeanList = List.of(new SomeBean("value01", "value02", "value03"),
												new SomeBean("value11", "value12", "value13"),
												new SomeBean("value21", "value22", "value23"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeanList);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}
}
