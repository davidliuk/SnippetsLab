int stringCount(String str) {
    if (str == null) {
        return 0;
    }
    
    int j = 1, answer = 0;
    for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) != '0') {
            continue;
        }
        
        j = Math.max(j, i + 1);
        while (j < str.length() && str.charAt(j) == '0') {
            j++;
        }
        
        answer += j - i;
    }
    
    return answer;
}
