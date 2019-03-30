package o2o.service;

import o2o.dto.HeadLineExecution;
import o2o.entity.HeadLine;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.List;

public interface HeadLineService {
	String HLLISTKEY = "headlinelist";

	/**
	 * 
	 * @param headLineCondition
	 * @return
	 * @throws IOException
	 */
	List<HeadLine> getHeadLineList(HeadLine headLineCondition)
			throws IOException;

	/**
	 * 
	 * @param headLine
	 * @param thumbnail
	 * @return
	 */
//	HeadLineExecution addHeadLine(HeadLine headLine,
//								  CommonsMultipartFile thumbnail);

	/**
	 *
	 * @param headLine
	 * @param thumbnail
	 * @param thumbnailChange
	 * @return
	 */
//	HeadLineExecution modifyHeadLine(HeadLine headLine,
//                                     CommonsMultipartFile thumbnail);

	/**
	 * 
	 * @param headLineId
	 * @return
	 */
//	HeadLineExecution removeHeadLine(long headLineId);

	/**
	 * 
	 * @param headLineIdList
	 * @return
	 */
//	HeadLineExecution removeHeadLineList(List<Long> headLineIdList);

}
