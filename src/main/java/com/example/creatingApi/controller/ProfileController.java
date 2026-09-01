package com.example.creatingApi.controller;

import com.example.creatingApi.model.Profile;
import com.example.creatingApi.model.DailyTask;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProfileController {

    private final List<DailyTask> routine = List.of(

                /*  Routine of chidambaram on a daily basis */

        new DailyTask("7.00 AM","Smokes a Cigarette,Brushes, Bathes and dress exquisitely","Health"),
        new DailyTask("8.00 AM","Eats food and getting ready to face the world.","Mentally"),
        new DailyTask("9.00 AM","Goes to the office and works his ass off till he depletes out of energy but never fails","Work"),
        new DailyTask("1.00 PM","Eats lunch and smokes a cigarette and thinks about the choices he chose in the past","Mentally"),
        new DailyTask("4.30 PM","Gets off from work to go to his home","Work"),
        new DailyTask("5.00 PM","Smokes 1 or 2 cigarettes while thinking about his life on what he is going to do","Mentally"),
        new DailyTask("6.00 PM","Again works his ass off learning new things and doing new things till 9.00 PM","Work"),
        new DailyTask("9.00 PM","Smokes 3 or 4 cigarettes and contemplating his life and thinks that he is a failure and a worthless piece of shit","Mentally"),
        new DailyTask("11.00 PM","Might go to have another study session of goes to sleep thinking about what he is going to do Tomorrow and hopes for a better future for himself and the people who surrounds him","Mentally")

    );

    private final Profile profile = new Profile(
            //Introduction
            "Chidambaram M",
            "My unmatched perspicacity coupled with sheer indefatigability" +
                    " makes me a feared opponent in any realm of the human endeavour",

            //Purpose of my life
            "You probably know what my name is,I am a MCA student who aspires to become an aerospace engineer" +
                    " and  wants to help humans and humanity to survive and thrive in extraterrestial planets",

            //Things I know currently
            List.of("HTML","REACT","JAVA","OOPS","SPRING FRAMEWORK","SQL","MONGO DB"),
            routine
    );

    @GetMapping("/about")
    public Profile getFullProfile(){
        return profile;
    }

    @GetMapping("/routine")
    public List<DailyTask> getFullDailyTask(){
        return profile.routine();
    }

    @GetMapping("/routine/categories/{categories}")
    public List<DailyTask> getRoutineBasedOnCategories(@PathVariable String categories){
            return routine.stream()
                    .filter(task -> task.categories().equalsIgnoreCase(categories))
                    .toList();
    }


}
