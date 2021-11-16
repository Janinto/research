//
//  Secure.swift
//  StudyForCombine
//
//  Created by reborn-m1macmini1 on 2021/11/16.
//

import SwiftUI
// 컨트롤
struct Secure: View {
    @State private var username = ""
    @State private var password = ""
    @State private var showPassword = false
    
    var body: some View {
        ZStack{
            Color.mint
                .edgesIgnoringSafeArea(.all) //SafeArea 까지 색을 채움
            VStack{
                HStack{ // 아이디
                    Image(systemName: "person")
                        .foregroundColor(.secondary)
                    TextField("아이디", text: $username)
                } .padding()
                    .background(Capsule().fill(Color.white))
                
                HStack { // 비밀번호
                    Image(systemName: "lock")
                        .foregroundColor(.secondary)
                    if showPassword {
                        TextField("비밀번호", text: $password)
                    } else {
                        SecureField("비밀번호", text: $password)
                    }
                    
                    Button(action: { self.showPassword.toggle()}) {
                        Image(systemName: "eye")
                            .foregroundColor(.secondary)
                    }
                    
                }.padding()
                .background(Capsule().fill(Color.white))
            } .padding()
        }
    }
}

struct Secure_Previews: PreviewProvider {
    static var previews: some View {
        Secure()
    }
}

