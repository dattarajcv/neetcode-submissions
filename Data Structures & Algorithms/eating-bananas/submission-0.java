class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1; // minimum 1 hour
        int maxSpeed = getMax(piles);

        while(minSpeed < maxSpeed){
            int midSpeed = minSpeed + (maxSpeed - minSpeed)/2;

            if(canConsume(piles,midSpeed,h)){
                // If can consume then try for smaller speeds
                maxSpeed = midSpeed;
            }else{
                minSpeed = midSpeed +1;
            }
        }

        return minSpeed;
    }

    private boolean canConsume(int[] piles, int speed, int h){
        int hours = 0;
        for(int pile: piles){
            hours += Math.ceil((double)pile/speed);
            // early termination
            if(hours > h){
                return false;
            }
        }

        return hours <= h;
    }

    private int getMax(int[] piles){
        int max = piles[0];

        for(int pile: piles){
            max = Math.max(max,pile);
        }

        return max;
    }
}