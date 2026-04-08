package com.codemorph.affiliate;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/affiliate")
public class AffiliateController {

    private Map<String, Integer> earnings = new HashMap<>();

    @GetMapping("/stats/{code}")
    public Map<String, Object> getStats(@PathVariable String code) {
        Map<String, Object> res = new HashMap<>();
        res.put("referralCode", code);
        res.put("earnings", earnings.getOrDefault(code, 0));
        res.put("users", new Random().nextInt(50));
        return res;
    }

    @PostMapping("/track")
    public String track(@RequestBody Map<String, String> body) {
        String code = body.get("code");
        earnings.put(code, earnings.getOrDefault(code, 0) + 50);
        return "tracked";
    }
}
