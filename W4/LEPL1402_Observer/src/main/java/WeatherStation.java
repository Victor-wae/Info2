
public class WeatherStation extends Observable {
    @Override
    public Observer[] getSubscribers() {
        Observer[] obs =  new Observer[subscribers.size()];
        for (int i = 0; i < obs.length; i++){
            obs[i] = subscribers.get(i);
        }
        return obs;
    }

    @Override
    public void broadcast(Pair<String, Integer> pair) {
        for (Observer obs : subscribers){
            if (obs.getZone() == pair.getZone()){
                obs.update(pair);
            }
        }
    }

    @Override
    public void addObserver(Observer sub) {
        if (!subscribers.contains(sub))subscribers.add(sub);
    }

    @Override
    public boolean removeObserver(Observer sub) {
        if(subscribers.contains(sub)){
            subscribers.remove(sub);
            return true;
        }
        return false;
    }

    @Override
    public void setAlert(String alert, int zone) {
        for (Observer sub : subscribers){
            if (sub.getZone() == zone){
                sub.update(alert);
            }
        }
    }
    // YOUR CODE HERE
}


