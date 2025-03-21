class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();  // Key: ingredient, Value: list of recipes
        Map<String, Integer> indegree = new HashMap<>();    // Key: recipe, Value: count of needed ingredients
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            indegree.put(recipe, ingredients.get(i).size());

            for (String in : ingredients.get(i)) {
                graph.computeIfAbsent(in, k -> new ArrayList<>()).add(recipe);
            }
        }

        Queue<String> queue = new LinkedList<>(available);

        while (!queue.isEmpty()) {
            String supply = queue.poll();
            if (!graph.containsKey(supply)) {
                continue;
            }

            for (String recipe : graph.get(supply)) {
                indegree.put(recipe, indegree.get(recipe) - 1);
                if (indegree.get(recipe) == 0) {
                    result.add(recipe);
                    queue.add(recipe);
                }
            }
        }

        return result;
    }
}