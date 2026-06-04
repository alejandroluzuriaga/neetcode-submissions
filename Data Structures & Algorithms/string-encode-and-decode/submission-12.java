class Solution {

    public String encode(List<String> strs) {
        String symbol = "@";
        String symbol2 = ",";
        StringBuilder encoded = new StringBuilder("");
        for(String elem : strs){
            for (int i = 0; i < elem.length(); i++){
                int ascii = (int) elem.charAt(i);
                encoded.append(Integer.toString(ascii));
                encoded.append(symbol2);
            }
        encoded.append(symbol);
        }
        return new String(encoded);
        //example: "123,@321,@"
    }

    public List<String> decode(String str) {
        Character symbol = '@';
        Character symbol2 = ',';
        List<String> decoded = new LinkedList<>();
        StringBuilder word = new StringBuilder("");
        StringBuilder letter = new StringBuilder("");
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == symbol){
                decoded.add(new String(word));
                word = new StringBuilder("");
                continue;
            }
            if (str.charAt(i) == symbol2){
                //'72' -> 72 -> ascii
                int integer = Integer.parseInt(new String(letter));
                word.append(Character.toString((char) integer)); //string
                letter = new StringBuilder("");
                continue;
            }
            //'7' -> '7', '2' -> '72'
            letter.append(str.charAt(i));
        }
        return decoded;
    }
}
