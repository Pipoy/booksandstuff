package com.mindteck.booksandstuff.service.cd;

import com.mindteck.booksandstuff.dto.CD.CDDTO;
import com.mindteck.booksandstuff.enitities.cd.CD;

import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
public interface CDService {
	void add(CDDTO cddto);
	List<CD> getCDs();
	CDDTO getCD(Long id);
}
