package uap.iweb.psndoc;

import javax.servlet.http.HttpServletResponse;

import nc.web.datatrans.itf.ITranslateDataService;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author liulibo
 * 
 */
@Controller
@RequestMapping("/psndoc")
public class PsnRestController {
	@Autowired
	IPsndocManagerService manager;
	@Autowired
	ITranslateDataService dataTranslator;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	void get(@PathVariable("id") String id, HttpServletResponse response)
			throws Exception {
		PsnAggVO agg = manager.query(id);
		response.setCharacterEncoding("UTF-8");
		JSONObject json = dataTranslator.transAggvoToJSON(agg);
		String jsonStr = json.toString();
		response.setContentType("text/html");
		response.getWriter().print(jsonStr);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	void save(@RequestParam("bill") String bill, HttpServletResponse response)
			throws Exception {
		PsnAggVO aggvo = dataTranslator.translateJsonToAggvo(PsnAggVO.class,
				bill);
		String pk_psn = manager.save(aggvo);
		response.setContentType("application/json");
		response.getWriter().print("{\"success\":\"true\"}");
	}
}
