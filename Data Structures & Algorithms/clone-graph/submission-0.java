/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        if (node.neighbors.isEmpty())
            return new Node(node.val);
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> toVisit = new LinkedList<>();
        toVisit.add(node);
        visited.put(node, new Node(node.val));
        
        while (!toVisit.isEmpty()){
            Node current = toVisit.poll();
            for(Node neighbor : current.neighbors){
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    toVisit.add(neighbor);
                }
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}