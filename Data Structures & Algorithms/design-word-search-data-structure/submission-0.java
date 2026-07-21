class WordDictionary {

    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }

            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int startIndex, TrieNode node){
        TrieNode curr = node;

        for(int i = startIndex; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(TrieNode child : curr.children){
                    if(child != null && search(word, i + 1, child)){
                        return true;
                    }
                }
                return false;
            }else{
                if(curr.children[c - 'a'] == null){
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
        }
        return curr.isEnd;
    }
}

class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    
    public TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
}
