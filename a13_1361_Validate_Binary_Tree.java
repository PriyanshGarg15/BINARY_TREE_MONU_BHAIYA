import java.util.*;

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, Integer> childToParent = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (childToParent.containsKey(leftChild[i])) {
                    return false; 
                }
                childToParent.put(leftChild[i], i);
            }
            
            if (rightChild[i] != -1) {
                if (childToParent.containsKey(rightChild[i])) {
                    return false;  
                }
                childToParent.put(rightChild[i], i);
            }
        }

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!childToParent.containsKey(i)) {
                if (root == -1) {
                    root = i;  
                } else {
                    return false;
                }
            }
        }

        if (root == -1) {
            return false; 
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (visited.contains(node)) {
                return false; 
            }
            visited.add(node);

            if (leftChild[node] != -1) {
                queue.offer(leftChild[node]);
            }

            if (rightChild[node] != -1) {
                queue.offer(rightChild[node]);
            }
        }

        return visited.size() == n;
    }
}
