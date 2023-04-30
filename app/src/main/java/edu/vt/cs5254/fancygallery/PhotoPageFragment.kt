package edu.vt.cs5254.fancygallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import edu.vt.cs5254.fancygallery.databinding.FragmentPhotoPageBinding

class PhotoPageFragment : Fragment() {

    private val args: PhotoPageFragmentArgs by navArgs()

    private var _binding : FragmentPhotoPageBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
        "Photo Page Fragment is Null!!!"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotoPageBinding.inflate(inflater, container, false)

        binding.apply {
            progressBar.max = 100
            webView.apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
                loadUrl(args.photoPageUri.toString())

                webChromeClient = object : WebChromeClient() {
                    override fun onReceivedTitle(view: WebView?, title: String?) {
                        val parent = requireActivity() as AppCompatActivity
                        parent.supportActionBar?.subtitle = title?.substringBefore('/')
                    }

                    override fun onProgressChanged(view: WebView?, newProgress: Int) {
                        if(newProgress == 100) {
                            progressBar.visibility = View.GONE
                        }
                        else {
                            progressBar.progress = newProgress
                        }
                    }
                }

            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        val parent = requireActivity() as AppCompatActivity
        parent.supportActionBar?.subtitle = null

        _binding = null
    }
}