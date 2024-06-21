package id.co.astratech.tugas3agit_achmad_zaky_fauzan.Controller;

import id.co.astratech.tugas3agit_achmad_zaky_fauzan.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class ImdbController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public Object getWeather(@PathVariable String city) {
        return weatherService.getCurrentWeather(city);
    }


}
