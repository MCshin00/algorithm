import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, Set<String>> reporterMap = new HashMap<>();

        for (String id : id_list) {
            reportCount.put(id, 0);
            reporterMap.put(id, new HashSet<>());
        }

        for (String rep : report) {
            String[] parts = rep.split(" ");
            String reporter = parts[0];
            String reported = parts[1];

            if (!reporterMap.get(reporter).contains(reported)) {
                reporterMap.get(reporter).add(reported);
                reportCount.put(reported, reportCount.get(reported) + 1);
            }
        }

        Set<String> bannedUsers = new HashSet<>();
        for (Map.Entry<String, Integer> entry : reportCount.entrySet()) {
            if (entry.getValue() >= k) {
                bannedUsers.add(entry.getKey());
            }
        }

        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            Set<String> reports = reporterMap.get(user);

            for (String reportedUser : reports) {
                if (bannedUsers.contains(reportedUser)) {
                    result[i]++;
                }
            }
        }

        return result;
    }
}