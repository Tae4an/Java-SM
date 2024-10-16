package edu.sm.frame;

public class Sql{
    public static String insert = "INSERT INTO crime_statistics \n" +
            "(major_category, minor_category, time_00_to_03, time_03_to_06, time_06_to_09, \n" +
            " time_09_to_12, time_12_to_15, time_15_to_18, time_18_to_21, time_21_to_24, \n" +
            " time_unknown, sunday, monday, tuesday, wednesday, thursday, friday, saturday)\n" +
            "VALUES \n" +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static String select = "SELECT * FROM crime_statistics";
    public static String delete = "DELETE FROM crime_statistics WHERE id = ?";
    public static String update = "UPDATE crime_statistics \n" +
            "SET major_category = ?, minor_category = ?, \n" +
            "    time_00_to_03 = ?, time_03_to_06 = ?, time_06_to_09 = ?, \n" +
            "    time_09_to_12 = ?, time_12_to_15 = ?, time_15_to_18 = ?, \n" +
            "    time_18_to_21 = ?, time_21_to_24 = ?, time_unknown = ?, \n" +
            "    sunday = ?, monday = ?, tuesday = ?, wednesday = ?, \n" +
            "    thursday = ?, friday = ?, saturday = ?\n" +
            "WHERE id = ?;";

    public static String selectByDay = "SELECT major_category, \n" +
            "       SUM(sunday) as total_sunday, \n" +
            "       SUM(monday) as total_monday,\n" +
            "       SUM(tuesday) as total_tuesday,\n" +
            "       SUM(wednesday) as total_wednesday,\n" +
            "       SUM(thursday) as total_thursday,\n" +
            "       SUM(friday) as total_friday,\n" +
            "       SUM(saturday) as total_saturday\n" +
            "FROM crime_statistics\n" +
            "GROUP BY major_category;";

    public static String selectByTime = "SELECT major_category, \n" +
            "       SUM(time_00_to_03) as total_00_to_03,\n" +
            "       SUM(time_03_to_06) as total_03_to_06,\n" +
            "       SUM(time_06_to_09) as total_06_to_09,\n" +
            "       SUM(time_09_to_12) as total_09_to_12,\n" +
            "       SUM(time_12_to_15) as total_12_to_15,\n" +
            "       SUM(time_15_to_18) as total_15_to_18,\n" +
            "       SUM(time_18_to_21) as total_18_to_21,\n" +
            "       SUM(time_21_to_24) as total_21_to_24\n" +
            "FROM crime_statistics\n" +
            "GROUP BY major_category;";

}
