package com.jotangi.greentravel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.jotangi.greentravel.Api.ApiUrl
import com.jotangi.greentravel.databinding.FragmentMallPaymoneyBinding
import com.jotangi.greentravel.ui.main.MainActivity




/**
 *
 * @Title: MallPayFragment.kt
 * @Package com.jotangi.healthy.HpayMall
 * @Description: MallPayFragment
 * @author Kelly
 * @date 2021-12
 * @version hpay_32版
 */
class MallPayFragment : ProjConstraintFragment() {

    private var _binding: FragmentMallPaymoneyBinding? = null

    companion object {
        const val TAG = "MallPayFragment"
        fun newInstance() = MallPayFragment()
    }

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMallPaymoneyBinding.inflate(inflater, container, false)
        val data: Bundle? = arguments
        initWebview()
        if (data != null) {
            val ResOrder = data.getString("ResOrder").toString()
            Log.d("ResOrder: "," "+ResOrder)


            binding.payMoney.loadUrl(ApiUrl.payUrl + ResOrder)
            Log.d("TAG "," "+ ApiUrl.payUrl + ResOrder)

        }
        val root: View = binding.root
        binding.apply { }

        return root
    }

    override fun onStart() {
        super.onStart()
        activityTitleRid = R.string.account_listitem_order
    }

    override fun onResume() {
        super.onResume()
        Log.d("FFFFF", "crashonResume")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initWebview() {
        val webView = binding.payMoney
        webView.getSettings().setJavaScriptEnabled(true)
        webView.getSettings().setAllowFileAccessFromFileURLs(true)
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true)
        webView.getSettings().setAllowFileAccessFromFileURLs(true)
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true)
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true)
        webView.getSettings().setDomStorageEnabled(true)
        webView.getSettings().setBuiltInZoomControls(false)
        webView.getSettings().setAllowFileAccess(true)
        webView.getSettings().setSupportZoom(false)
        webView.getSettings().setSupportMultipleWindows(true)
        webView.getSettings().setLoadWithOverviewMode(true)
        webView.getSettings().setSaveFormData(true)
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE)
        webView.getSettings().setPluginState(WebSettings.PluginState.ON)
        webView.setWebChromeClient(object : WebChromeClient() {

        })
        webView.setWebViewClient(object : WebViewClient() {
            // 在點擊請求的是鏈接是纔會調用，重寫此方法返回true表明點擊網頁裏面的鏈接還是在當前的webview裏跳轉，不跳到瀏覽器那邊。這個函數我們可以做很多操作，比如我們讀取到某些特殊的URL，於是就可以不打開地址，取消這個操作，進行預先定義的其他操作，這對一個程序是非常必要的。
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                val data: Bundle? = arguments
                val ResOrder = data?.getString("ResOrder").toString()
                val url = ApiUrl.payUrl + ResOrder
                // 判斷url鏈接中是否含有某個字段，如果有就執行指定的跳轉（不執行跳轉url鏈接），如果沒有就加載url鏈接
                return if (url.contains("")) {
                    fragmentListener.onAction(FUNC_MALL_PAY_TO_MEMBER, null)
                    true
                } else {
                    false
                }
            }
        })

//        if (fragmentListener != null) {
//            fragmentListener.onAction(FUNC_MALL_PAY_TO_MEMBER, null)
//        }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}