   int totalBooks;

    public int findMinHeight(int bookIndex, int[][] books, int curShelfWidth, int curShelfHeight, int shelfWidth, int[][] dp) {
        // Base case: when we reach the last book
        if (bookIndex == totalBooks - 1) {
            // If the last book fits on the current shelf
            if (books[bookIndex][0] <= curShelfWidth) {
                return Math.max(curShelfHeight, books[bookIndex][1]);
            }
            // If the last book needs a new shelf
            return curShelfHeight + books[bookIndex][1];
        }

        // If already solved, just return the result
        if (dp[bookIndex][curShelfWidth] != -1) {
            return dp[bookIndex][curShelfWidth];
        }

        // Case 1: Place on the same shelf
        int sameShelf = Integer.MAX_VALUE;
        if (books[bookIndex][0] <= curShelfWidth) {
            sameShelf = findMinHeight(bookIndex + 1, books, curShelfWidth - books[bookIndex][0], Math.max(curShelfHeight, books[bookIndex][1]), shelfWidth, dp);
        }

        // Case 2: Place on a new shelf
        int newShelf = curShelfHeight + findMinHeight(bookIndex + 1, books, shelfWidth - books[bookIndex][0], books[bookIndex][1], shelfWidth, dp);

        // Store the result in dp array
        dp[bookIndex][curShelfWidth] = Math.min(sameShelf, newShelf);
        return dp[bookIndex][curShelfWidth];
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        totalBooks = books.length;
        int[][] dp = new int[totalBooks][shelfWidth + 1];
        for (int i = 0; i < totalBooks; i++) {
            for (int j = 0; j <= shelfWidth; j++) {
                dp[i][j] = -1;
            }
        }
        return findMinHeight(0, books, shelfWidth, 0, shelfWidth, dp);
    }
