package com.livestreaming.streaming;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static com.livestreaming.streaming.NewsController.getOptions;

@Controller
public class VideoController {

    @PostMapping("/cricket")
    public String welcome(){
        return "Home";
    }

    @GetMapping("/cricket/starSportHindi")
    public String playHindiVideo(Model model) {

        String videoUrl = "https://crichdstreaming.xyz/embed2.php?id=starsp3";
        model.addAttribute("videoUrl", videoUrl);
        return "videoPage";
    }
    @GetMapping("/cricket/starSportHindi/player2")
    public String playHindiVideoPlayer2(Model model) {

        String videoUrl = "https://stream.crichd.vip/update/star1hi.php";
        model.addAttribute("videoUrl", videoUrl);
        return "videoPage";
    }
    @GetMapping("/cricket/ptv")
    public String ptv(Model model) {

        String videoUrl = "https://stream.crichd.vip/update/ptv.php";
        model.addAttribute("videoUrl", videoUrl);
        return "videoPage";
    }
    @GetMapping("/cricket/willowCricket")
    public String willowCricket(Model model) {

        String videoUrl = "https://stream.crichd.vip/update/willowcricket.php";
        model.addAttribute("videoUrl", videoUrl);
        return "videoPage";
    }


}
