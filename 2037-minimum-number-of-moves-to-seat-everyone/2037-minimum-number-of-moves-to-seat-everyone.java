class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int count = 0;
        Arrays.sort(seats);
        Arrays.sort(students); 
        
        int i = 0;
        while(i<seats.length){
            count += Math.abs(seats[i] - students[i]);
            i++; 
        }
        return count; 
        
    }
}