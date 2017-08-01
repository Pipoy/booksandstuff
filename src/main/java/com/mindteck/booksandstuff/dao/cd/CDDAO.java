package com.mindteck.booksandstuff.dao.cd;

import com.mindteck.booksandstuff.enitities.cd.CD;

import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
public interface CDDAO {

	void add(CD cd);
	List<CD> getCDs();
	CD getCD(Long id);


}
