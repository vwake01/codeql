package generatedtest;

import java.net.URI;
import java.net.URL;
import okhttp3.HttpUrl;
import okhttp3.Request;

// Test case generated by GenerateFlowTestCase.ql
public class Test {

	Object source() {
		return null;
	}

	void sink(Object o) {}

	public void testSinks() {
		new Request((HttpUrl) source(), null, null, null, null); // $ hasValueFlow
		new Request.Builder().url((String) source()); // $ hasValueFlow
	}

	public void test() throws Exception {

		{
			// "okhttp3;HttpUrl$Builder;false;addEncodedPathSegment;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.addEncodedPathSegment(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;addEncodedPathSegment;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.addEncodedPathSegment(in);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;addEncodedPathSegments;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.addEncodedPathSegments(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;addEncodedPathSegments;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.addEncodedPathSegments(in);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;addEncodedQueryParameter;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.addEncodedQueryParameter(null, null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;addEncodedQueryParameter;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.addEncodedQueryParameter(in, null);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;addPathSegment;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.addPathSegment(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;addPathSegment;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.addPathSegment(in);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;addPathSegments;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.addPathSegments(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;addPathSegments;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.addPathSegments(in);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;addQueryParameter;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.addQueryParameter(null, null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;addQueryParameter;;;Argument[0..1];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.addQueryParameter(in, null);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;addQueryParameter;;;Argument[0..1];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.addQueryParameter(null, in);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;build;;;Argument[-1];ReturnValue;taint"
			HttpUrl out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.build();
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;encodedFragment;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.encodedFragment(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;encodedFragment;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.encodedFragment(in);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;encodedPassword;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.encodedPassword(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;encodedPath;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.encodedPath(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;encodedPath;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.encodedPath(in);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;encodedQuery;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.encodedQuery(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;encodedQuery;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.encodedQuery(in);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;encodedUsername;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.encodedUsername(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;fragment;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.fragment(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;fragment;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.fragment(in);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;host;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.host(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;host;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.host(in);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;password;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.password(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;port;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.port(0);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;port;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			int in = (int) source();
			out.port(in);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;query;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.query(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;query;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.query(in);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;removeAllEncodedQueryParameters;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.removeAllEncodedQueryParameters(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;removeAllQueryParameters;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.removeAllQueryParameters(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;removePathSegment;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.removePathSegment(0);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;scheme;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.scheme(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;scheme;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.scheme(in);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;setEncodedPathSegment;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.setEncodedPathSegment(0, null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;setEncodedPathSegment;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			int in = (int) source();
			out.setEncodedPathSegment(in, null);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;setEncodedQueryParameter;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.setEncodedQueryParameter(null, null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;setEncodedQueryParameter;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.setEncodedQueryParameter(in, null);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;setPathSegment;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.setPathSegment(0, null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;setPathSegment;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			int in = (int) source();
			out.setPathSegment(in, null);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;setQueryParameter;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.setQueryParameter(null, null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;setQueryParameter;;;Argument[0];Argument[-1];taint"
			HttpUrl.Builder out = null;
			String in = (String) source();
			out.setQueryParameter(in, null);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl$Builder;false;username;;;Argument[-1];ReturnValue;value"
			HttpUrl.Builder out = null;
			HttpUrl.Builder in = (HttpUrl.Builder) source();
			out = in.username(null);
			sink(out); // $ hasValueFlow
		}
		{
			// "okhttp3;HttpUrl;false;parse;;;Argument[0];ReturnValue;taint"
			HttpUrl out = null;
			String in = (String) source();
			out = HttpUrl.parse(in);
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl;false;uri;;;Argument[-1];ReturnValue;taint"
			URI out = null;
			HttpUrl in = (HttpUrl) source();
			out = in.uri();
			sink(out); // $ hasTaintFlow
		}
		{
			// "okhttp3;HttpUrl;false;url;;;Argument[-1];ReturnValue;taint"
			URL out = null;
			HttpUrl in = (HttpUrl) source();
			out = in.url();
			sink(out); // $ hasTaintFlow
		}

	}

}
