package edu.sm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CrimeStatistics {
    private int id;
    private String majorCategory;
    private String minorCategory;
    private int time00To03;
    private int time03To06;
    private int time06To09;
    private int time09To12;
    private int time12To15;
    private int time15To18;
    private int time18To21;
    private int time21To24;
    private int timeUnknown;
    private int sunday;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    private int saturday;
}
