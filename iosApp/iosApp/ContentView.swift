import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel:ViewModel
    
	var body: some View {
        Text(viewModel.text)
	}
}

extension ContentView{
    class ViewModel: ObservableObject{
        @Published var text = "Loading..."
        init(){
            Greeting().greeting{
                greeting,error in
                /**
                 When calling Kotlin suspend functions from Swift,
                 completion handlers might be called on threads other thant the main one
                 Tha's why DispatchQueue.main.async is used to update the text property
                 */
                DispatchQueue.main.async{
                    //Data will be loaded here
                    if let greeting = greeting {
                        self.text = greeting
                    }else{
                        self.text = error?.localizedDescription ?? "error"
                    }
                }
            }
      
        }
    }
}
