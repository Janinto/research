//
//  SwiftUIView.swift
//  StudyForCombine
//
//  Created by reborn-m1macmini1 on 2021/11/10.
//

import SwiftUI
import Combine

    
// 버튼을 누를 떄 마다 name 프로퍼티의 값을 바꾸는데 이에따라 뷰도 자동으로 내용이 업데이트됨
//State로 표기된 퍼블리셔의 변화에따라 섭스크라이버인 View가 그 변화에 대응함
// @Statw 특정 view에서만 사용하는 프로퍼티 state가 변경되면 자동으로 변환시키고 사용자인터페이스를 업데이트 함

struct ThisIsStateView: View {
    @State private var name = "World"
    
    
    var body: some View {
        VStack{
            Text("Hello, \(name)! ")
                .padding()
            Button(
                action: {self.switchName() }, label: { Text("Switch") }
            )
        }
        
        
    }
    
    func switchName() {
        if name == "World" {
            name = "Universe"
        } else {
            name = "World"
        }
    }
}
    


struct SwiftUIView_Previews: PreviewProvider {
    static var previews: some View {
        ThisIsStateView()
    }
}
