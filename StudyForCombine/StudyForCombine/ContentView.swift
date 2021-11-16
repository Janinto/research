//
//  ContentView.swift
//  StudyForCombine
//
//  Created by reborn-m1macmini1 on 2021/11/10.
//

import SwiftUI
import Combine


struct ContentView: View {

    @State private var value = false
    @ObservedObject var data = MyData()
    
    var body: some View {
        NavigationView {
            List {
                NavigationLink(destination: ThisIsStateView()) {
                CustomCell(cellNum: "State(Source Of Truth)")
                }
                NavigationLink(destination: MyToggleButton(value: $value)) {
                CustomCell(cellNum: "Binding")
                }
                NavigationLink(destination: musicPlay()) {
                    CustomCell(cellNum: "State and Binding(클릭시 화면 변경)")
                }
                NavigationLink(destination: MyData2()) {
                    CustomCell(cellNum: "Observable and ObservedObject")
                        .font(.custom("", size: 17))
                }
                NavigationLink(destination: Secure()) {
                    CustomCell(cellNum: "SecureField(Controls)")
                }
                
                
            
            }
            
            
            .listStyle(GroupedListStyle())
            .navigationBarTitle("About Combine")
        }
        
        
        
    }
}



 
struct CustomCell: View {
    var cellNum: String
 
    var body: some View {
        HStack {
        
            //NavigationLink(destination: DetailView()) {
              
                Image(systemName: "paperplane.fill")
                Text("\(cellNum)")
                
                
            //}
        }
    }
}


        

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

