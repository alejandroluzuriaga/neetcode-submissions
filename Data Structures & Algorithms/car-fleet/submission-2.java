class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Set<Pair<Integer, Double>> s = new TreeSet<>(new Comparator<Pair<Integer, Double>>(){ 
            public int compare(Pair<Integer, Double> p1, Pair<Integer, Double> p2){
                if (p1.getKey() < p2.getKey())
                    return 1;
                else
                    return -1;
            }});
        int fleets = 0;
        for(int i = 0; i < position.length; i++){
            Double reachTime = (target - position[i]) / (double) speed[i];
            s.add(new Pair<Integer, Double>(position[i], reachTime));
        }
        Double currentFleetReachTime = 0.0;
        for(Pair<Integer, Double> elem : s){
            System.out.println(elem);
            Double reachTime = elem.getValue();
            if (reachTime > currentFleetReachTime){
                currentFleetReachTime = reachTime;
                fleets++;
            }
            else
                continue;
        }
        return fleets;
    }
}
