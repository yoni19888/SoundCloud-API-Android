SoundCloud-API
==============

Simple Soundcloud API for android

* First, Add the library to the main folder(Project\app\src\main\java).

Create new instance 

```
API sndcdn = new API("<CLIENT ID>", "<CLIENT SECRET>");
```

Get Track details

```
try{
            sndcdn.getTrack(
                    new ISndcdn() {
                        @Override
                        public void onSuccess(Object result) {
                            TrackDetails track = (TrackDetails) result;
                        }

                        @Override
                        public void onFail(Exception e) {
                            //Something here...
                        }
                    },
                    
                    "<TRACK URL>"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }
```


Get user details

```
try{
            sndcdn.getUser(
                    new ISndcdn() {
                        @Override
                        public void onSuccess(Object result) {
                            UserDetails user = (UserDetails) result;
                        }

                        @Override
                        public void onFail(Exception e) {
                            //Something here...
                        }
                    },
                    
                    (int)<USER ID>
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }
```

For more details: Example.java
