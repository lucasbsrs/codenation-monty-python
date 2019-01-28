package challenge;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		Optional<Quote> obj = null;
		try {
			int random = (int) (Math.random() * 100);
			obj = repository.findById(random);
		} catch (Exception e) {
			e.getMessage();
		}

		return obj.get();
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> listQuote = repository.findByActorContains(actor);
		Quote quote = listQuote.get(new Random().nextInt(listQuote.size())); 
		return quote;
	}

}
