import java.util.*;

public class P0207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) edges.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            edges.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }
        Queue<Integer> ready = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) ready.add(i);
        int completed = 0;
        while (!ready.isEmpty()) {
            int course = ready.remove();
            completed++;
            for (int next : edges.get(course)) if (--indegree[next] == 0) ready.add(next);
        }
        return completed == numCourses;
    }
}
