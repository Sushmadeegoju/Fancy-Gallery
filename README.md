# Fancy-Gallery
Fancy Gallery is an android application that follows the Model-View-ViewModel (MVVM) architecture and contains two primary fragments: Gallery and Map. The Gallery Fragment is responsible for displaying a grid of photos retrieved from the Flickr API, while the Map Fragment displays the location where each photo was taken.

To accomplish this, the Model component of the MVVM architecture interacts with the Flickr API to fetch photo and location data. The View component consists of the Gallery and Map fragments, which provide a user-friendly interface for displaying the data. The ViewModel component acts as a mediator between the Model and View components, processing data from the Model and updating the View as necessary. The Gallery Fragment employs a RecyclerView to efficiently display multiple photos in a grid. When a user selects a photo, the application launches a WebView to display the image in full resolution. The Map Fragment utilizes a Google Maps API to show the photo's location on a map. The ViewModel component retrieves location data from the Model and passes it to the Map Fragment for display.

Overall, Fancy Gallery is a well-designed android application that provides users with an enjoyable experience for browsing photos on Flickr and exploring their associated locations on a map.