package dictionary;

public class Node {
    String word;
    Node left;
    Node right;  
    public Object translation;

    public Node (String words) {
        this.word=words;
        this.left=null;
        this.right=null;
    }

    public Node(String word, Object translation) {
        this.word = word;
        this.translation = translation;
        this.left = null;
        this.right = null;
    }
    
    public String getTranslation() {
        return (String) this.translation;
    } 
    public void setTranslation(String translation) {
        this.translation = translation;
    }
}