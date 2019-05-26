package com.example.demo.web;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import com.example.demo.util.BootstrapTable;
import com.example.demo.util.R;

@RestController
@RequestMapping("book")
public class BookController
{

	@Resource
	BookService bookService;

	@RequestMapping("/list")
	public BootstrapTable list(String name, int pageSize, int offset)
	{
		Page<Book> books = bookService.findAll(offset, pageSize, name);
		return BootstrapTable.turn(books);
	}

	@RequestMapping("/add")
	public R add(@RequestBody Book book)
	{
		bookService.save(book);
		return R.ok();
	}

	@RequestMapping("/update")
	public R update(@RequestBody Book book)
	{
		bookService.edit(book);
		return R.ok();
	}

	@RequestMapping("/delete")
	public R delete(int id)
	{
		System.out.println(id);
		bookService.delete(id);
		return R.ok();
	}

}