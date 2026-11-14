
class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0)
            return new int[0][0];

        if (intervals.length == 1)
            return intervals;

        // Ordenamos por el primer elemento de cada intervalo
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> calculation = new ArrayList<>();

        int i = 0;

        // Intervalo que estamos construyendo
        int[] newInterval = new int[2];

        newInterval[0] = intervals[0][0];
        newInterval[1] = intervals[0][1];

        while (i < intervals.length - 1) {

            int[] currentInterval = intervals[i];
            int[] nextInterval = intervals[i + 1];

            // currentInterval = [A,B]
            // nextInterval = [C,D]
            int c = nextInterval[0];
            int d = nextInterval[1];

            if (newInterval[1] < c) {

                // No hay solapamiento
                calculation.add(newInterval);

                // Empezamos un nuevo intervalo
                newInterval = new int[]{c, d};

            } else {

                // Hay solapamiento
                newInterval[1] = Math.max(newInterval[1], d);
            }

            i++;
        }

        // Añadimos el último intervalo pendiente
        calculation.add(newInterval);

        return calculation.toArray(new int[calculation.size()][]);
    }
}
