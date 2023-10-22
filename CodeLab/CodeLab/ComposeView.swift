import SwiftUI
import iosApp

struct ComposeView : UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        return KotlinEntryKt.compose()
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        
    }
}
