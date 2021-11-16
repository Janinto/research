//
//  MyData2.swift
//  StudyForCombine
//
//  Created by reborn-m1macmini1 on 2021/11/16.
//

import SwiftUI

struct MyData2: View {
    
    @ObservedObject var data = MyData()
    var body: some View{
        Text("Hello, \(data.name)!")
            .padding()
        Button(
            action: { self.data.switchName()},
            label: { Text(self.data.buttonTitle) }
        )
    }
}


class MyData: ObservableObject {
    @Published var name = "World"
    @Published var buttonTitle = "Switch to Universe"
    
    func switchName(){
        if name == "World" {
            name = "Universe"
            buttonTitle = "Switch to World"
        } else {
            name = "World"
            buttonTitle = "Switch to Universe"
        }
    }
    
}

struct MyData2_Previews: PreviewProvider {
    static var previews: some View {
        MyData2()
    }
}
