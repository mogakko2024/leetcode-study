class Trie() {
    private val root = TreeNode()

    fun insert(word: String) {
        var current = root

        for (i in word.indices) {
            val ind = word[i] - 'a'
            if (current.children[ind] == null) {
                current.children[ind] = TreeNode()
            }
            current = current.children[ind]!! // 다음 TreeNode 를 가리킴
        }

        current.end = true // 마지막 요소인걸 저장
    }

    fun search(word: String): Boolean {
        var current = root

        for (i in word.indices) {
            val ind = word[i] - 'a'
            if (current.children[ind] == null) return false
            current = current.children[i]!!
        }

        return current.end // 모든 문자가 같아야하니 마지막 요소인지 검사
    }

    fun startsWith(prefix: String): Boolean {
        var current = root

        for (i in prefix.indices) {
            val ind = prefix[i] - 'a'
            if (current.children[ind] == null) return false
            current = current.children[i]!!
        }

        return true // prefix 만 같으면 되니 ind 로 찾았으면 true 리턴
    }

    class TreeNode(
        val children: Array<TreeNode?> = arrayOfNulls(26),
        var end: Boolean = false,
    )
}
