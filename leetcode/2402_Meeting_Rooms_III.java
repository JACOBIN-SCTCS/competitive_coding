
class OccupiedRoom
{   
    int room;
    int endTime;

    OccupiedRoom(int room, int endTime)
    {
        this.room = room;
        this.endTime = endTime;
    }
}

class Solution {
    
    
    
    public int mostBooked(int n, int[][] meetings) {
        
        Arrays.sort(meetings, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b)
            {
                if(a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });

        int ans_count = 0;
        int[] meeting_counts = new int[n];
        
        PriorityQueue<Integer> room = new PriorityQueue<Integer>();
        for(int i=0; i < n ; ++i)
            room.add(i);

        PriorityQueue<OccupiedRoom> oc_q = new PriorityQueue<OccupiedRoom>(
            1 , new Comparator<OccupiedRoom>(){
                @Override 
                public int compare(OccupiedRoom a, OccupiedRoom b)
                {
                    if(a.endTime == b.endTime)
                        return a.room - b.room;
                    return a.endTime-b.endTime;
                }
            }
        );

        for(int[] meeting : meetings)
        {
            int startTime = meeting[0];
            while(!oc_q.isEmpty() && oc_q.peek().endTime <= startTime)
            {
                OccupiedRoom oc_room = oc_q.poll();
                room.add(oc_room.room);
            }
            if(!room.isEmpty())
            {
                int room_no = room.poll();
                meeting_counts[room_no] +=1;
                ans_count = Math.max(ans_count,meeting_counts[room_no]);
                oc_q.add(new OccupiedRoom(room_no , meeting[1]));
            }
            else
            {
                OccupiedRoom nextRoom = oc_q.poll();
                if(nextRoom != null)
                {
                    meeting_counts[nextRoom.room] += 1;
                    ans_count = Math.max(ans_count, meeting_counts[nextRoom.room]);
                    nextRoom.endTime = nextRoom.endTime + (meeting[1] - meeting[0]);
                    oc_q.add(nextRoom);
                }
            }

        }
    
        for(int i=0; i < n ; ++i)
        {
            if(meeting_counts[i] == ans_count)
                return i;
        }

        return 0;
    }
}
