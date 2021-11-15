//
//  MyToggleButton.swift
//  StudyForCombine
//
//  Created by reborn-m1macmini1 on 2021/11/15.
//

import SwiftUI

//State는 특정 View 소유의 프로퍼티이자 상태를 명시할 때 사용합니다. 그렇다면 이와는 다르게 남의 View의 State를 가져와서 자기 자신이 사용하게 되는 경우도 있을 수 있습니다. Binding은 이렇게 남의 소유의 State를 자신과 묶어줄 때 사용합니다.

//Binding은 두 가지 형태로 표현됩니다. 하나는 $ 마크로 자신의 State를 남에게 연결시켜주는 경우, 그리고 남의 State를 연결하기 위해 @Binding을 사용하는 경우입니다.

//다만 차이가 있다면 해당 값을 자신이 아닌 다른 View가 바꾼다는 것이지요. 즉 ContentView 소유의 value 프로퍼티를 $ 마크를 붙여서 연결하도록 MyToggleButton에 넘겨주었고, MyToggleButton이 이 연결을 받아서 값을 마음대로 바꾸고 있습니다.

//결과적으로 State의 소유권을 잠시 남에게 양도해 줄 수 있는 기능이라고 볼 수 있겠네요.
struct MyToggleButton: View{
    
    @Binding var value: Bool
    
    var body: some View {
        Button(action: {
            self.value.toggle()
        }, label: {
            Text(self.value ? "Hi" : "Reborn")
        })
    }
    
    
}
