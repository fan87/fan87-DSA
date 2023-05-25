package q371_380

class Q380 {

    // TODO: Transfer RandomizedSet to not use hashset
    class RandomizedSet(): HashSet<Int>() {

        fun insert(`val`: Int): Boolean {
            return add(`val`)
        }


        fun getRandom(): Int {
            return random()
        }

    }

}