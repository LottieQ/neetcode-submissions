class Twitter {
    Map<Integer, List<int[]>> tweetList;
    Map<Integer, Set<Integer>> followList;
    int timestamp = 0;

    public Twitter() {
        tweetList = new HashMap<>();
        followList = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        int[] newTweet = {timestamp, tweetId};
        timestamp++;

        tweetList.computeIfAbsent(userId, k -> new ArrayList<>()).add(newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a , b) -> a[0] - b[0]
        );

        Set<Integer> set = new HashSet<>();
        if(followList.containsKey(userId)){
            set = followList.get(userId);
        }
        set.add(userId);
        for(int id : set){
            if(tweetList.containsKey(id)){
                for(int[] tweet: tweetList.get(id)){
                    pq.offer(tweet);
                    if(pq.size() > 10) {
                        pq.poll();
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll()[1]);
        }
        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followList.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followList.get(followerId).remove(followeeId);
    }
}
