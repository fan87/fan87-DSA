package q141_150

class Q146 {

    class LRUCache(capacity: Int) {

        private val nodes = object : LinkedHashMap<Int, Int>(capacity, 0.75f, true) {
            override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?) = size > capacity
        }

        fun get(key: Int) = nodes[key] ?: -1

        fun put(key: Int, value: Int) {
            nodes[key] = value
        }

    }

}