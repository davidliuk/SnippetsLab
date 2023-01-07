// https://segmentfault.com/a/1190000037510116?utm_source=sf-related
// https://www.modb.pro/db/109745

import SwiftUI

struct ViewControllerWrapper: UIViewControllerRepresentable {
    @EnvironmentObject var model: Model
    @Binding var showSheet: Bool
    
    typealias UIViewControllerType = ViewController

    func makeUIViewController(context: UIViewControllerRepresentableContext<ViewControllerWrapper>) -> ViewControllerWrapper.UIViewControllerType {
        let mainStoryboard: UIStoryboard = UIStoryboard(name: "Main", bundle: nil)
        let mainViewController: ViewController = mainStoryboard.instantiateViewController(withIdentifier: "View") as! ViewController
        // 通过代理模式，使调制器可以工作
        mainViewController.delegate = context.coordinator
        return mainViewController
    }

    func updateUIViewController(_ uiViewController: ViewControllerWrapper.UIViewControllerType, context: UIViewControllerRepresentableContext<ViewControllerWrapper>) {
        print(model.info)
        uiViewController.model = model
    }
    
    // 用来从UIKit内部传递数据到SwiftUI，原理是代理模式
    func makeCoordinator() -> Coordinator {
        return Coordinator(parent: self)
    }
    
    class Coordinator: NSObject, PresentDelegate {
        var parent: ViewControllerWrapper
        
        init(parent: ViewControllerWrapper) {
            self.parent = parent
        }
        
        func presentMethod(view: StickyNoteView) {
            parent.showSheet = true
            parent.model.selectedView = view
            parent.model.info = view.info
        }
        
    }
}

protocol PresentDelegate: NSObjectProtocol {
    //展示方法，使得可以展示下拉框
    func presentMethod(view: StickyNoteView)
}
